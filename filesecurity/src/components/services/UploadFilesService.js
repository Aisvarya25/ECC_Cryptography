import axios from 'axios';

const USER_API_BASE_URL = "http://localhost:8080/api/v1/fileRegister";

class UploadFilesService {

    getFiles(){
        return axios.get(USER_API_BASE_URL);
    }

    createFile(users){
        return axios.post(USER_API_BASE_URL, users);
    }

    getFileById(userId){
        return axios.get(USER_API_BASE_URL + '/' + userId);
    }

    updateFile(users, userId){
        return axios.put(USER_API_BASE_URL + '/' + userId, users);
    }

    deleteFile(userId){
        return axios.delete(USER_API_BASE_URL + '/' + userId);
    }
}

export default new UploadFilesService()