DESCRIPTION = "Recipe to clone, resolve dependencies, and build MOGBE ROS 2 workspace"
LICENSE = "CLOSED"

# Clone repositories
SRC_URI = "git://github.com/gsarenas/mogbe;branch=main;protocol=https;name=mogbe \
    git://github.com/gsarenas/serial;branch=newans_ros2;protocol=https;name=serial \
    git://github.com/gsarenas/diffdrive_arduino;branch=humble-mogbe;protocol=https;name=diffdrive_arduino \
    git://github.com/gsarenas/ldlidar_stl_ros2;branch=master;protocol=https;name=ldlidar_stl_ros2 \
    "

SRC_URI[mogbe.sha256sum] = "0fd43a570a9e4326ac05b561b9dbdcf81439e1ce652aa58d27dc27977f654951"
SRC_URI[serial.sha256sum] = "39de3f0ac773d8e18b9b725ed8161f4207b410cbf36ee2f38eda6c078eb65ae8"
SRC_URI[diffdrive_arduino.sha256sum] = "5d12386da83a381810f57c8723a081caafa1de9d52eed090e7b4e9009b07eaec"
SRC_URI[ldlidar_stl_ros2.sha256sum] = "ac5828ee19785d8ac572da0202acb8dbcaad265db09f6d8d6f656d37bad780de"

SRCREV_FORMAT = "mogbe serial diffdrive_arduino ldlidar_stl_ros2"

SRCREV_mogbe = "${AUTOREV}"
SRCREV_serial = "${AUTOREV}"
SRCREV_diffdrive_arduino = "${AUTOREV}"
SRCREV_ldlidar_stl_ros2 = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS = "python3-colcon-core-native python3-rosdep-native python3-rospkg-native"

do_configure() {
    # Create mogbe_ws directory structure
    mkdir -p ${S}/mogbe_ws/src

    # Create symbolic links, overwrite if they exist
    ln -snf ${S}/mogbe ${S}/mogbe_ws/src/mogbe
    ln -snf ${S}/serial ${S}/mogbe_ws/src/serial
    ln -snf ${S}/diffdrive_arduino ${S}/mogbe_ws/src/diffdrive_arduino
    ln -snf ${S}/ldlidar_stl_ros2 ${S}/mogbe_ws/src/ldlidar_stl_ros2

    # Configure rosdep
    mkdir -p ${S}/etc/ros
    rosdep init --rosdistro=humble || true
    rosdep update || true
    rosdep install --from-paths ${S}/mogbe_ws/src -y --ignore-src || true
}

do_compile() {
    # Build the workspace using colcon
    cd ${S}/mogbe_ws
    colcon build --symlink-install
}

do_install() {
    # Install the built files
    install -d ${D}/mogbe/mogbe_ws
    cp -r ${S}/mogbe_ws/* ${D}/mogbe/mogbe_ws/

    # Remove TMPDIR references from setup.sh and local_setup.sh
    sed -i "s|${TMPDIR}||g" ${D}/mogbe/mogbe_ws/install/setup.sh
    sed -i "s|${TMPDIR}||g" ${D}/mogbe/mogbe_ws/install/local_setup.sh

    # Remove TMPDIR references from log files
    sed -i "s|${TMPDIR}||g" ${D}/mogbe/mogbe_ws/log/build_*/logger_all.log
}

FILES:${PN} += "/mogbe/mogbe_ws/*"
