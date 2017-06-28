#!/bin/bash
set -e

MYSQL_ROOT_PASSWORD="123456"

chown -R mysql:mysql /var/lib/mysql
mysql_install_db --user mysql > /dev/null

tfile=`mktemp`
if [[ ! -f "$tfile" ]]; then
    return 1
fi

cat << EOF > $tfile
USE mysql;
FLUSH PRIVILEGES;
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;
UPDATE user SET password=PASSWORD("$MYSQL_ROOT_PASSWORD") WHERE user='root';
EOF

/usr/sbin/mysqld --bootstrap --verbose=0 < $tfile
rm -f $tfile
