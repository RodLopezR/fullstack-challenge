import { GetRequest, PostRequest, PutRequest, DeleteRequest, BaseUrl } from './AxiosRequests';

const ListarClientes = async () => {
   return await GetRequest(`${BaseUrl}cliente`, {})
}

const ListarCliente = async (id) => {
   return await GetRequest(`${BaseUrl}cliente/${id}`, {});
}

const Registrar = async (cliente) => {
   return await PostRequest(`${BaseUrl}cliente`, cliente);
}

const Actualizar = async (cliente) => {
   return await PutRequest(`${BaseUrl}cliente`, cliente);
}

const Eliminar = async (id) => {
   return await DeleteRequest(`${BaseUrl}cliente${id}`, {});
}

export {
   ListarClientes,
   ListarCliente,
   Registrar,
   Actualizar,
   Eliminar
};