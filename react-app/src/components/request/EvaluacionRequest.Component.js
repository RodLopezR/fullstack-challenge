import { GetRequest, PostRequest, PutRequest, DeleteRequest, BaseUrl } from './AxiosRequests';

const ListarEvaluaciones = async () => {
   return await GetRequest(`${BaseUrl}evaluacion`, {})
}

const ListarEvaluacionesCliente = async (id, fechaini, fechafin) => {
   const url = `${BaseUrl}cliente/evaluacion/${id}/${fechaini}/${fechafin}`;
   console.log(url);
   return await GetRequest(url, {})
}

const ListarEvaluacion = async (id) => {
   return await GetRequest(`${BaseUrl}evaluacion/${id}`, {});
}

const Registrar = async (request) => {
   return await PostRequest(`${BaseUrl}evaluacion`, request);
}

const Actualizar = async (request) => {
   return await PutRequest(`${BaseUrl}evaluacion`, request);
}

const Eliminar = async (id) => {
   return await DeleteRequest(`${BaseUrl}evaluacion/${id}`, {});
}

export {
   ListarEvaluaciones,
   ListarEvaluacionesCliente,
   ListarEvaluacion,
   Registrar,
   Actualizar,
   Eliminar
};