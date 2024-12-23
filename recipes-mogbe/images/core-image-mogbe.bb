SUMMARY = "MOGBE recipe"
DESCRIPTION = "Support recipe for MOGBE Yocto Project build"
LICENSE = "CLOSED"

inherit core-image

require recipes-core/images/ros-image-core.bb

IMAGE_FEATURES:append = " \
    debug-tweaks \
    allow-root-login \
    allow-empty-password \
    ssh-server-openssh \
    "

PACKAGES_DEV_TOOLS = " \
    htop \
    nano \
    python3 \
    python3-pip \
    python3-pyserial \
    openssh-sftp-server \
    tzdata \
    "

PACKAGES_MOGBE = " \
    mogbe-ws \
    "

PACKAGES_RASPBERRYPI = " \
    bcm2835-tests \
    raspi-gpio \
    rpio \
    rpi-gpio \
    pi-blaster \
    python3-adafruit-circuitpython-register \
    python3-adafruit-platformdetect \
    python3-adafruit-pureio \
    python3-rtimu \
    connman \
    connman-client \
    wireless-regdb-static \
    bluez5 \
    "

IMAGE_INSTALL:append = " \
    ${PACKAGES_DEV_TOOLS} \
    ${PACKAGES_MOGBE} \
    ${PACKAGES_RASPBERRYPI} \
    "

# Add 20 GB of extra space [kB]
IMAGE_ROOTFS_EXTRA_SPACE = "20971520"

IMAGE_FSTYPES:append = " ext4.gz tar.gz wic wic.bmap"

# WSK_FILES = "mogbe-sdcard-image.wks.in"
