DESCRIPTION = "MOGBE's custom package groups for ROS env"

inherit packagegroup
inherit ros_distro_${ROS_DISTRO}

PACKAGES = "${PN}"

RDEPENDS:${PN} = " \
    mogbe-ws \
    packagegroup-ros2-demos \
    ros-base \
    "
