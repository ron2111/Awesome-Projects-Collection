import React, { Component } from "react";

export class Loader extends Component {
	render() {
		return (
			<div className="text-center mt-5">
				<img src="/loader.gif" alt="Loading" />
			</div>
		);
	}
}

export default Loader;
