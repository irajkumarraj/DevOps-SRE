# Copyright (c) HashiCorp, Inc.
# SPDX-License-Identifier: MPL-2.0

provider "aws" {
  region = "ap-south-1"
  access_key = file("../keys/AccessKeyID.txt")
  secret_key = file("../keys/SecretAccessKey.txt")
}

variable "Access_key" {
  type = string
  # default = file("../keys/AccessKeyID.txt")
  description = "fetch access key from the given file"
}

variable "Secret_key" {
  type = string
  # default = file("../keys/SecretAccessKey.txt")
  description = "fetch access key from the given file"
}

provider "random" {}

resource "random_pet" "name" {}

resource "aws_instance" "web" {
  ami           = "ami-019715e0d74f695be"
  instance_type = "t3.micro"
  user_data     = file("init-script.sh")
  vpc_security_group_ids = [aws_security_group.web-sg.id]

  tags = {
    Name = random_pet.name.id
  }
}

resource "aws_security_group" "web-sg" {
  name = "${random_pet.name.id}-sg"

  ingress {
    from_port = 80
    to_port = 80
    protocol = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port = 22
    to_port = 22
    protocol = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port = 0
    to_port = 0
    protocol = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
  
}
