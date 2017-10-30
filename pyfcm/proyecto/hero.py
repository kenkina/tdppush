from flask import Flask
from flask_restful import reqparse, abort, Api, Resource
from pyfcm import FCMNotification
import json

app = Flask(__name__)
api = Api(app)

parser = reqparse.RequestParser()


class SendNotification(Resource):
    def post(self):
        try:
            args = parser.parse_args()
            registration_ids = args['registration_ids']
            message_title = "TDPPush"
            message_body = args['message_body']
            alumnoId = args['alumnoId']
            push_service = FCMNotification(
                api_key="AAAABE0h958:APA91bFX-dDdTgFWbuIHgE4fN0mR0EycwzWdd0wq4NUmND_KDRpIBFgN_X-9KOEO6A70VzJwv0WFaX-gCoa7kDJwQeAUS_zKMrRKXBRspL8K-y3grFXR54F2I7spytY_sOfJFS6ifCOa")
            data_message = {
                "alumnoId": alumnoId
            }
            result = push_service.notify_multiple_devices(registration_ids=registration_ids, message_title=message_title,
                                                          message_body=message_body, data_message=data_message)
            return {'status': 200, 'UserId': str(result)}
        except Exception as e:
            return {'status': 400, 'error': str(e)}


api.add_resource(SendNotification, '/sendNotification')

if __name__ == '__main__':
    app.run(debug=True)
