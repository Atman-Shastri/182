set x=wscript.createobject("wscript.shell")
i=0
do until i=500
wscript.sleep 100
x.sendkeys"{CAPSLOCK}"
x.sendkeys"{NUMLOCK}"
x.sendkeys"I am a virus"
x.sendkeys"{SCROLLLOCK}"
i = i + 1
Loop