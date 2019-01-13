#!/bin/sh

<<<<<<< HEAD
=======
# master -> main server
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
if [ "${TRAVIS_PULL_REQUEST}" = "false" ] && [ "${TRAVIS_BRANCH}" = "master" ]; then
  export SSHPASS=${SFTP_PASSWORD}
  sshpass -e sftp -oStrictHostKeyChecking=no -oUserKnownHostsFile=/dev/null -oLogLevel=ERROR -oBatchMode=no -oPort=${SFTP_PORT} -b - ${SFTP_USER}@${SFTP_HOST}:${SFTP_PATH} << !
    put target/novelengine-*.jar novelengine.jar
    bye
!
  echo "Artifact upload status: "$?
<<<<<<< HEAD
elif [ "${TRAVIS_PULL_REQUEST}" = "false" ] && [ "${TRAVIS_BRANCH}" = "devel" ]; then
  export SSHPASS=${SFTP_PASSWORD}
  sshpass -e sftp -oStrictHostKeyChecking=no -oUserKnownHostsFile=/dev/null -oLogLevel=ERROR -oBatchMode=no -oPort=${SFTP_PORT} -b - ${SFTP_USER}@${SFTP_HOST}:${DSFTP_PATH} << !
    put target/novelengine-*.jar noveldev.jar
=======

# devel -> dev server
elif [ "${TRAVIS_PULL_REQUEST}" = "false" ] && [ "${TRAVIS_BRANCH}" = "devel" ]; then
  export SSHPASS=${SFTP_PASSWORD}
  sshpass -e sftp -oStrictHostKeyChecking=no -oUserKnownHostsFile=/dev/null -oLogLevel=ERROR -oBatchMode=no -oPort=${SFTP_PORT} -b - ${SFTP_USER}@${SFTP_HOST}:${DSFTP_PATH} << !
    put target/novelengine-*.jar novelengine.jar
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
    bye
!
  echo "Artifact upload status: "$?
else
  echo "Skipping artifact upload."
fi
