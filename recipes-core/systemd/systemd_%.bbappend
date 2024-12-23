FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://timesyncd.conf"
SRC_URI += "file://system.conf"

PACKAGECONFIG:append = " openssl"
PACKAGECONFIG:append = " resolved networkd"

EXTRA_OECONF:append = " --with-time-epoch=0"

DEF_FALLBACK_NTP_SERVERS="time.cloudflare.com time1.google.com time2.google.com time3.google.com time4.google.com"
EXTRA_OEMESON += ' \
	-Dntp-servers="${DEF_FALLBACK_NTP_SERVERS}" \
'

do_install:append() {
    install -d ${D}${sysconfdir}/systemd
    install -m 0644 ${WORKDIR}/timesyncd.conf ${D}${sysconfdir}/systemd/
    install -m 0644 ${WORKDIR}/system.conf ${D}${sysconfdir}/systemd/

    # Disable getty@tty1 from starting at boot time.
    sed -i -e "s/enable getty@.service/disable getty@.service/g" ${D}${systemd_unitdir}/system-preset/90-systemd.preset
}
