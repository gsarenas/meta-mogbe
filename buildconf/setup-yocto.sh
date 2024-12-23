#!/bin/sh

# Variables
ECHO=$(which echo)
BUILDDIR="../build"
FIRST_TIME=0

# Change directory to layers
cd layers || { echo "Directory 'layers' not found! Exiting..."; return 1; }

# Check if local.conf exists, indicating if this is the first time
if [ ! -f ${BUILDDIR}/conf/local.conf ]; then
    FIRST_TIME=1
fi

# Source the Yocto environment setup script
. ./oe-init-build-env ${BUILDDIR}

# Display the available FlexDS targets
echo ""
echo "MOGBE target is"
echo "    core-image-mogbe"

# If this is the first time, set up configuration files
if [ $FIRST_TIME -eq 1 ]; then
    mkdir -p conf
    cp ../layers/meta-mogbe/buildconf/*.conf conf/

    echo ""
    $ECHO -e "\033[1mA sample conf/local.conf file has been created"
fi