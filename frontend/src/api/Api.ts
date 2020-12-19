import { AxiosRestApplicationClient } from './computing-systems';
import axios from 'axios';

const instance = axios.create({ withCredentials: false });
const API_ENDPOINT = process.env.REACT_APP_API_ENDPOINT;

export const Api = new AxiosRestApplicationClient(API_ENDPOINT || '/api', instance);
