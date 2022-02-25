import axios from "axios";
const MESSAGE_API_URL = 'http://localhost:8080/api/v1.0/messages'

class MessageService{

    getAllMessages(){
        return axios.get(MESSAGE_API_URL)
    }

    deleteMessageById(id){
        return axios.delete(MESSAGE_API_URL+'/'+id)
    }

    findMessageById(id){
        return axios.get(MESSAGE_API_URL+'/'+id)
    }

    udateMessage(id, message){
        return axios.put(MESSAGE_API_URL+'/'+id,message)
    }

    saveMessage(message){
        return axios.post(MESSAGE_API_URL,message)
    }


}export default new MessageService();