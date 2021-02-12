#!/bin/bash

IDP_HOST=idp.ssocircle.com
IDP_PORT=443
CERTIFICATE_FILE=ssocircle.cert
KEYSTORE_FILE=samlKeystore.jks
KEYSTORE_PASSWORD=nalle123

openssl s_client -host $IDP_HOST -port $IDP_PORT -prexit -showcerts </dev/null | sed -ne '/-BEGIN CERTIFICATE-/,/-END CERTIFICATE-/p' > $CERTIFICATE_FILE
keytool -delete -alias ssocircle -keystore $KEYSTORE_FILE -storepass $KEYSTORE_PASSWORD
keytool -import -alias ssocircle -file $CERTIFICATE_FILE -keystore $KEYSTORE_FILE -storepass $KEYSTORE_PASSWORD -noprompt
#keytool -import -alias adfs1.testesaml.local -file public.crt -keystore samlKeystore.jks -storepass nalle123 -noprompt

rm $CERTIFICATE_FILE
