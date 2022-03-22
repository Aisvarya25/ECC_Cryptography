import axios from 'axios';

const API_BASE_URL = "http://localhost:8080/api/v1/filesList";

class FileListServices {

    getFiles(){
        return axios.get(API_BASE_URL);
    }

    createFiles(files){
        return axios.post(API_BASE_URL, files);
    }

    getFilesById(fileId){
        return axios.get(API_BASE_URL + '/' + fileId);
    }

    updateFiles(file, fileId){
        return axios.put(API_BASE_URL + '/' + fileId, file);
    }

    deleteFiles(fileId){
        return axios.delete(API_BASE_URL + '/' + fileId);
    }
}

export default new FileListServices()