@echo
adb disconnect
adb connect 192.168.%1
adb root
adb connect 192.168.%1
adb remount
