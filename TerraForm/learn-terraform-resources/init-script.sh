#!/bin/bash
# Adapted for Ubuntu 24.04

# Update system
apt update -y && apt upgrade -y

# Remove old Apache if any (optional)
apt remove -y apache2

# Install Apache, PHP, MySQL
apt install -y apache2 php mysql-server php-mysql curl unzip

# Start and enable Apache
systemctl start apache2
systemctl enable apache2

# Set permissions
chown -R www-data:www-data /var/www
chmod 2775 /var/www
find /var/www -type d -exec chmod 2775 {} \;
find /var/www -type f -exec chmod 0664 {} \;

# Move to web root
cd /var/www/html || exit

# Download instance ID and example PHP page
curl http://169.254.169.254/latest/meta-data/instance-id -o index.html
curl -O https://raw.githubusercontent.com/hashicorp/learn-terramino/master/index.php