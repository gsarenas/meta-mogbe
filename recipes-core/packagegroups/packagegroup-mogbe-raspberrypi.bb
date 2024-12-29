DESCRIPTION = "MOGBE's custom package groups for Raspberry Pi board"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS:${PN} = " \
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
