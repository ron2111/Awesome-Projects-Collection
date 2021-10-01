import axios from "axios";

export default axios.create({ baseURL: "https://restcountries.eu/rest/v2/" });
