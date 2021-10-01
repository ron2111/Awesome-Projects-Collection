import pandas as pd
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.metrics.pairwise import cosine_similarity

moviesPath = './Database.csv'

df2 = pd.read_csv(moviesPath)

# Import CountVectorizer and create the count matrix
cVectorizer = CountVectorizer(stop_words='english')
COUNT_MAT = cVectorizer.fit_transform(df2['meta'])

# Compute the Cosine Similarity matrix based on the count_matrix
COS_SIM_MAT = cosine_similarity(COUNT_MAT, COUNT_MAT)

# Reset index of our main DataFrame and construct reverse mapping as before
df2 = df2.reset_index()
indices = pd.Series(df2.index, index=df2['title'])

# Function that takes in movie title as input and outputs most similar movies
def getRecommendations(title, COS_MAT = COS_SIM_MAT):
	# Get the index of the movie that matches the title
	idx = indices[title]

	# Get the pairwsie similarity scores of all movies with that movie
	similarMovies = list(enumerate(COS_MAT[idx]))
		
	# Sort the movies based on the similarity scores
	similarMovies = sorted(similarMovies, key=lambda x: x[1], reverse=True)

	# Get the scores of the 10 most similar movies
	similarMovies = similarMovies[1:11]

	#Get the movie similarity scores
	# similarity_scores = [round(i[1], 3) for i in similarMovies]
	similarity_scores = [i[1] for i in similarMovies]

	# Get the movie indices
	movie_indices = [i[0] for i in similarMovies]

	# Return the top 10 most similar movies
	return df2['title'].iloc[movie_indices].tolist(), similarity_scores

# print(getRecommendations("The Matrix"))