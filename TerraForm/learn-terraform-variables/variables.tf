# Copyright (c) HashiCorp, Inc.
# SPDX-License-Identifier: MPL-2.0

# Variable declarations
variable "enable_nat_gateway" {
    type = bool
    description = "True/False to enable and disable NAT gateway"
    default = false
}

variable "instance_count" {
    type = number
    description = "No of instance you want on aws"
    default = 1
}

variable "instance_type" {
    type = string
    description = "Instance type t2.micro/t3.micro etc."
    default = "t3.micro"
}

variable "ami_name" {
    type = string
    description = "name of ami"
    default = "ami-0ffef61f6dc37ae89"
  
}
