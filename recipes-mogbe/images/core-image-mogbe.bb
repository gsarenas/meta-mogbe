SUMMARY = "MOGBE recipe"
DESCRIPTION = "Support recipe for MOGBE Yocto Project build"
LICENSE = "CLOSED"

inherit core-image
inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

IMAGE_FEATURES:append = " \
    debug-tweaks \
    allow-root-login \
    allow-empty-password \
    ssh-server-openssh \
    tools-debug \
    tools-sdk \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base x11-sato', \
                                                       '', d), d)} \
    "

IMAGE_FEATURES:remove = " \
    package-management \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'x11-base', '', d)} \
    "

IMAGE_INSTALL:append = " \
    packagegroup-mogbe-dev-tools \
    packagegroup-mogbe-docker \
    packagegroup-mogbe-raspberrypi \
    packagegroup-mogbe-ros \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland xterm', '', d)} \
    "

# Add 20 GB of extra space [kB]
IMAGE_ROOTFS_EXTRA_SPACE = "20971520"

IMAGE_FSTYPES = "wic"
SDIMG_ROOTFS_TYPE = "ext4"

WKS_FILES = "mogbe-sdcard-image.wks"
