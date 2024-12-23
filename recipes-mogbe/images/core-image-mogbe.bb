SUMMARY = "MOGBE recipe"
DESCRIPTION = "Support recipe for MOGBE Yocto Project build"
LICENSE = "CLOSED"

inherit core-image

# IMAGE_FEATURES:append = ""

# PACKAGES_DEV_TOOLS = ""

# IMAGE_INSTALL:append = " \
#     ${PACKAGES_DEV_TOOLS} \
#     "

# Add 20 GB of extra space [kB]
# IMAGE_ROOTFS_EXTRA_SPACE = "20971520"

# IMAGE_FSTYPES:append = " ext4.gz targ.gz wic wic.bmap"

# WSK_FILES = "mogbe-sdcard-image.wks.in"
