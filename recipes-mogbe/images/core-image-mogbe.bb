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
    bash \
    boost-dev \
    coreutils \
    cmake \
    curl \
    diffutils \
    g++ \
    gawk \
    gcc \
    gdb \
    git \
    grep \
    htop \
    iputils \
    libstdc++-dev \
    lsof \
    make \
    man \
    nano \
    net-tools \
    nmap \
    parted \
    pkgconfig \
    python3 \
    python3-colcon-bash \
    python3-colcon-cd \
    python3-colcon-cmake \
    python3-colcon-common-extensions \
    python3-colcon-core \
    python3-colcon-defaults \
    python3-colcon-devtools \
    python3-colcon-library-path \
    python3-colcon-metadata \
    python3-colcon-notification \
    python3-colcon-output \
    python3-colcon-package-information \
    python3-colcon-package-selection \
    python3-colcon-parallel-executor \
    python3-colcon-pkg-config \
    python3-colcon-python-setup-py \
    python3-colcon-recursive-crawl \
    python3-colcon-ros \
    python3-colcon-test-result \
    python3-dev \
    python3-empy \
    python3-pip \
    python3-pyserial \
    python3-rosdep \
    python3-rosdistro \
    python3-rospkg \
    python3-vcstool \
    openssh-sftp-server \
    openssl-dev \
    rsync \
    sed \
    strace \
    tar \
    tcpdump \
    tree \
    tzdata \
    unzip \
    urdf \
    vim \
    wget \
    zlib-dev \
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

PACKAGES_ROS = " \
    ros-base \
    ros-core \
    packagegroup-ros2-demos \
    "

IMAGE_INSTALL:append = " \
    ${PACKAGES_DEV_TOOLS} \
    ${PACKAGES_MOGBE} \
    ${PACKAGES_RASPBERRYPI} \
    ${PACKAGES_ROS} \
    "

# Add 20 GB of extra space [kB]
IMAGE_ROOTFS_EXTRA_SPACE = "20971520"

IMAGE_FSTYPES:append = " tar tar.gz wic wic.bmap"
SDIMG_ROOTFS_TYPE = "ext4.xz"

# WSK_FILES = "mogbe-sdcard-image.wks.in"
