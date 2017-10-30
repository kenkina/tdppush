import requests
import json


url = 'https://fcm.googleapis.com/fcm/send'

headers = {
    'content-type': 'application/json',
    'Authorization': 'key=AAAABE0h958:APA91bFX-dDdTgFWbuIHgE4fN0mR0EycwzWdd0wq4NUmND_KDRpIBFgN_X-9KOEO6A70VzJwv0WFaX-gCoa7kDJwQeAUS_zKMrRKXBRspL8K-y3grFXR54F2I7spytY_sOfJFS6ifCOa'
}

data = {
    'body': 'Alumno Víctor se ha unido al salón WX11',
    'title': 'Firebase notification',
    'data':
    {
        'alumnoId': '12'
    },
    'to': 'co5Cn7rzJX8:APA91bGv9ViAbpkCeUoF9pOyYb2MZdGGT6fdorDtOtth0dGYlmjmgoiAsGUnWwg9rORSJU82nKumyJYTO9Ii7gOqQ5Lns9yZaH-d65w0rbNL-Nfcujoj1zgP19cB5c4BzfMmY9QWbdKf", "co5Cn7rzJX8:APA91bGv9ViAbpkCeUoF9pOyYb2MZdGGT6fdorDtOtth0dGYlmjmgoiAsGUnWwg9rORSJU82nKumyJYTO9Ii7gOqQ5Lns9yZaH-d65w0rbNL-Nfcujoj1zgP19cB5c4BzfMmY9QWbdKf'
}

r = requests.post(url, data=json.dumps(data), headers=headers)
print(r)