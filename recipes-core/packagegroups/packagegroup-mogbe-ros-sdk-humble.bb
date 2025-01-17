DESCRIPTION = "MOGBE's custom package groups for ROS env + SDK"

inherit packagegroup
inherit ros_distro_${ROS_DISTRO}

PACKAGES = "${PN}"

RDEPENDS:${PN} = " \
    action-tutorials-cpp \
    action-tutorials-interfaces \
    action-tutorials-py \
    angles \
    automotive-navigation-msgs \
    automotive-platform-msgs \
    automotive-autonomy-msgs \
    autoware-auto-msgs \
    composition \
    demo-nodes-cpp \
    demo-nodes-cpp-rosnative \
    demo-nodes-py \
    depthimage-to-laserscan \
    dummy-map-server \
    dummy-robot-bringup \
    dummy-sensors \
    examples-rclcpp-minimal-action-client \
    examples-rclcpp-minimal-action-server \
    examples-rclcpp-minimal-client \
    examples-rclcpp-minimal-composition \
    examples-rclcpp-minimal-publisher \
    examples-rclcpp-minimal-service \
    examples-rclcpp-minimal-subscriber \
    examples-rclcpp-minimal-timer \
    examples-rclcpp-multithreaded-executor \
    examples-rclpy-executors \
    examples-rclpy-minimal-action-client \
    examples-rclpy-minimal-action-server \
    examples-rclpy-minimal-client \
    examples-rclpy-minimal-publisher \
    examples-rclpy-minimal-service \
    examples-rclpy-minimal-subscriber \
    image-tools \
    intra-process-demo \
    joy \
    lifecycle \
    logging-demo \
    pcl-conversions \
    quality-of-service-demo-cpp \
    quality-of-service-demo-py \
    ros-base \
    tlsf \
    tlsf-cpp \
    topic-monitor \
    rclcpp-dev \
    std-msgs-dev \
    ecl-tools \
    compressed-image-transport \
    rclcpp \
    rclc \
    rcl-yaml-param-parser \
    gpsd-client \
    image-pipeline \
    depth-image-proc \
    image-common \
    image-transport \
    camera-calibration-parsers \
    imu-complementary-filter \
    imu-filter-madgwick \
    swri-prefix-tools \
    swri-roscpp \
    marti-can-msgs \
    marti-common-msgs \
    marti-dbw-msgs \
    marti-nav-msgs \
    marti-perception-msgs \
    marti-sensor-msgs \
    marti-status-msgs \
    marti-visualization-msgs \
    libmavconn \
    laser-filters \
    fastrtps \
    mavros \
    mavros-msgs \
    odom-to-tf-ros2 \
    pendulum-control \
    rc-genicam-api \
    rc-reason-msgs \
    ros2launch-security-examples \
    rosapi \
    rosapi-msgs \
    rosbridge-server \
    sros2 \
    v4l2-camera \
    vision-msgs \
    "
