FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://ssh_banner_file"
SRC_URI:append = " file://id_ed25519_mogbe.pub"

FILES:${PN} += "/mogbe/*"
FILES:${PN} += "/mogbe/keypairs/*"

do_install:append(){
	install -d ${D}/mogbe
	install -d ${D}/mogbe/keypairs
	install -m 0640 ${WORKDIR}/ssh_banner_file ${D}/mogbe/
	install -m 0700 ${WORKDIR}/id_ed25519_mogbe.pub ${D}/mogbe/keypairs
}
