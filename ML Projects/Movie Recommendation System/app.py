from flask import Flask, render_template, request
from MovieRecommender import getRecommendations
import json

app = Flask(__name__)

MOVIES = json.loads(open('./movies.json', 'r').read())

@app.route('/',methods = ['GET'])
def show_index_html():
    # return DATA
	return render_template('index.html', headings = [], movies = [], MOVIES = MOVIES, scores = [])

@app.route('/send_data', methods = ['POST'])
def get_data_from_html():
		movieInp = request.form['search']
		if movieInp == "":
			return "Empty input. Please Try again."
		# print(movieInp)
		movies, scores = getRecommendations(movieInp)
		return render_template('index.html', headings = ["Recommended Movies", "Cosine Similarity Score"], movies = movies, MOVIES = MOVIES, scores = scores)

if __name__ == '__main__':
	app.run(debug=True)
	# app.run(host="0.0.0.0", port=5000, debug=True)