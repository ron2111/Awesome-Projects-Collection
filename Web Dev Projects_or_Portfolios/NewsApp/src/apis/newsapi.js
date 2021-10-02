import axios from "axios";

export default axios.create({
	baseURL: "https://newsapi.org/v2",
	headers: {
		Authorization: process.env.REACT_APP_API_KEY,
	},
});
