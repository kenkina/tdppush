from pyfcm import FCMNotification
import json

push_service = FCMNotification(api_key="AAAABE0h958:APA91bFX-dDdTgFWbuIHgE4fN0mR0EycwzWdd0wq4NUmND_KDRpIBFgN_X-9KOEO6A70VzJwv0WFaX-gCoa7kDJwQeAUS_zKMrRKXBRspL8K-y3grFXR54F2I7spytY_sOfJFS6ifCOa")

registration_ids = ["co5Cn7rzJX8:APA91bGv9ViAbpkCeUoF9pOyYb2MZdGGT6fdorDtOtth0dGYlmjmgoiAsGUnWwg9rORSJU82nKumyJYTO9Ii7gOqQ5Lns9yZaH-d65w0rbNL-Nfcujoj1zgP19cB5c4BzfMmY9QWbdKf", "co5Cn7rzJX8:APA91bGv9ViAbpkCeUoF9pOyYb2MZdGGT6fdorDtOtth0dGYlmjmgoiAsGUnWwg9rORSJU82nKumyJYTO9Ii7gOqQ5Lns9yZaH-d65w0rbNL-Nfcujoj1zgP19cB5c4BzfMmY9QWbdKf"]
message_title = "TDPPush"
message_body = "Alumno Víctor se ha unido al salón WX11"
data_message = {
	"alumnoId": "12"
}
result = push_service.notify_multiple_devices(registration_ids=registration_ids, message_title=message_title, message_body=message_body, data_message=data_message)

print (result)