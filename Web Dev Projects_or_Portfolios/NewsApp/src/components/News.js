import React, { Component } from "react";
import InfiniteScroll from "react-infinite-scroll-component";
import NewsItem from "./NewsItem";
import Loader from "./Loader";

export class News extends Component {
	constructor(props) {
		super(props);

		document.title = `${this.props.headingTitle} - WorldNews`;
	}

	componentDidUpdate(prevProps) {
		if (prevProps.headingTitle !== this.props.headingTitle) {
			document.title = `${this.props.headingTitle} - WorldNews`;
		}
	}

	renderNewsItems() {
		const { articles } = this.props;
		return articles.map(article => {
			return <NewsItem key={article.url} article={article} />;
		});
	}

	render() {
		return (
			<div className="container my-4">
				<h1 className="my-4 text-center">WorldNews - {this.props.headingTitle}</h1>
				{this.props.loading ? <Loader /> : null}
				<InfiniteScroll dataLength={this.props.articles.length} next={this.props.fetchMoreData} hasMore={this.props.articles.length < this.props.totalResults} loader={<Loader />}>
					<div className="container">
						<div className="row row-cols-1 row-cols-md-3 g-4">{this.renderNewsItems()}</div>
					</div>
				</InfiniteScroll>
			</div>
		);
	}
}

export default News;
