import axios from 'axios';



const GetRequest = async (url, params) => {
    return new Promise(function(resolve, reject){
        axios.get(url, params)
            .then(response => {
                if(response != null && response.data != null && typeof response.data === "object"){
                    resolve(response.data);
                }else{ 
                    reject({ message: "No se completó la operación" });
                }
            }).catch(error => {  
                reject({ message: error.message });
            });
    });
};

const PostRequest = async (url, _params) => {
    return new Promise(function(resolve, reject){
        const params = JSON.stringify(_params);
        const headers = { headers: { 'Content-Type': 'application/json' } };
        
        axios.post(url, params, headers)
            .then(response => {
                if(response != null && response.data != null && typeof response.data === "object"){
                    resolve(response.data);
                }else{ 
                    reject({ message: "No se completó la operación" });
                }
            }).catch(error => {
                reject({ message: error.message });
            });
    });
};

const PutRequest = async (url, params) => {
    return new Promise(function(resolve, reject){
        axios.put(url, params)
            .then(response => {
                if(response != null && response.data != null && typeof response.data === "object"){
                    resolve(response.data);
                }else{ 
                    reject({ message: "No se completó la operación" });
                }
            }).catch(error => {  
                reject({ message: error.message });
            });
    });
};

const DeleteRequest = async (url, params) => {
    return new Promise(function(resolve, reject){
        axios.delete(url, params)
            .then(response => {
                if(response != null && response.data != null && typeof response.data === 'number'){
                    resolve("Operación exitosa");
                }else{ 
                    reject({ message: "No se completó la operación" });
                }
            }).catch(error => {  
                reject({ message: error.message });
            });
    });
};

const BaseUrl = "http://localhost:5000/api/";

export {
    GetRequest,
    PostRequest,
    PutRequest,
    DeleteRequest,
    BaseUrl
}