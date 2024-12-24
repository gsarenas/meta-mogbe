DESCRIPTION = "Recipe to clone, resolve dependencies, and build MOGBE ROS 2 workspace"
LICENSE = "CLOSED"

RDEPENDS:${PN} = "perl"

# Clone repositories
SRC_URI = " \
    git://github.com/gsarenas/mogbe;branch=main;protocol=https;name=mogbe;subdir=mogbe \
    git://github.com/gsarenas/serial;branch=newans_ros2;protocol=https;name=serial;subdir=serial \
    git://github.com/gsarenas/diffdrive_arduino;branch=humble-mogbe;protocol=https;name=diffdrive_arduino;subdir=diffdrive_arduino \
    git://github.com/gsarenas/ldlidar_stl_ros2;branch=master;protocol=https;name=ldlidar_stl_ros2;subdir=ldlidar_stl_ros2 \
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

S = "${WORKDIR}"

do_install() {
    install -d -m 0755 ${D}/mogbe/mogbe_ws/src/mogbe
    cp -R --no-dereference --preserve=mode,links -v ${S}/mogbe ${S}/serial ${S}/diffdrive_arduino ${S}/ldlidar_stl_ros2 ${D}/mogbe/mogbe_ws/src
}

FILES:${PN} += "/mogbe/mogbe_ws/src/*"
