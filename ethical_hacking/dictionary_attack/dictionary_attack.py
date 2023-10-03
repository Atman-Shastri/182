import hashlib

found = False

password_hash=input("Enter MD5 hash: ")
dictionary=input("Enter dictionary filename: ")

try:
    password_file = open(dictionary,"r")
except:
    print("No file found")
    quit()

for word in password_file:
    enc_word = word.encode('utf-8')
    digest = hashlib.md5(enc_word.strip()).hexdigest()
    if(digest==password_hash):
        print(f"Password is --> {word}\n")
        found = True
        break

if not found:
    print("Password is very strong, couldn't decrypt it\n")