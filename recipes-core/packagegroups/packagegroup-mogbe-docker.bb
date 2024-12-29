DESCRIPTION = "MOGBE's custom package groups for Docker"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS:${PN} = " \
    docker \
    docker-compose \
    python3-docker \
    "
