import React, { Component } from "react";

export class NewsItem extends Component {
	render() {
		const { title, description, url, urlToImage, publishedAt, author, source } = this.props.article;
		const date = new Date(publishedAt);

		return (
			<div className="col col-md-6 col-lg-4">
				<div className="card h-100">
					<img src={urlToImage ? urlToImage : "/altImage.jpg"} className="card-img-top" alt="Not Found" />
					<div className="card-body">
						<h5 className="card-title">{title}</h5>
						<p className="text-muted">
							Published at {date.toLocaleString()} by <strong className="me-2">{author ? author : "Unknown"}</strong>
							<span className="badge bg-secondary">{source.name}</span>
						</p>
						<p className="card-text">{description}</p>
					</div>
					<div className="card-footer">
						<div className="d-grid gap-2">
							<button className="btn btn-primary" type="button">
								<a href={url} className="text-decoration-none text-white" target="_blank" rel="noreferrer">
									Read More
								</a>
							</button>
						</div>
					</div>
				</div>
			</div>
		);
	}
}

export default NewsItem;
