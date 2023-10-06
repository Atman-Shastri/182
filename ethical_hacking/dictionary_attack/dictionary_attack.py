import hashlib


if __name__=="__main__":
    found = False

    password_hash=input("Enter MD5 hash: ")
    dictionary=input("Enter dictionary filename: ")

    try:
        with open(dictionary,'r') as password_file:
            for word in password_file:
                enc_word = word.encode('utf-8')
                digest = hashlib.md5(enc_word.strip()).hexdigest()
                if(digest==password_hash):
                    print(f"Password is --> {word}\n")
                    found = True
                    break
            if not found:
                print("Password is very strong, couldn't decrypt it\n")
    except FileNotFoundError:
        print(f"{dictionary} does not exist, check path or filename")
