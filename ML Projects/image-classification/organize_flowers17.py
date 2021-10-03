#-----------------------------------------
# DOWNLOAD AND ORGANIZE FLOWERS17 DATASET
#-----------------------------------------
import os
import glob
import datetime
import tarfile
import urllib.request

def download_dataset(filename, url, work_dir):
	if not os.path.exists(filename):
		print("[INFO] Downloading flowers17 dataset....")
		filename, _ = urllib.request.urlretrieve(url + filename, filename)
		statinfo = os.stat(filename)
		print("[INFO] Succesfully downloaded " + filename + " " + str(statinfo.st_size) + " bytes.")
		untar(filename, work_dir)

def jpg_files(members):
	for tarinfo in members:
		if os.path.splitext(tarinfo.name)[1] == ".jpg":
			yield tarinfo

def untar(fname, path):
	tar = tarfile.open(fname)
	tar.extractall(path=path, members=jpg_files(tar))
	tar.close()
	print("[INFO] Dataset extracted successfully.")

#-------------------------
# MAIN FUNCTION
#-------------------------
if __name__ == '__main__':
	flowers17_url  = "http://www.robots.ox.ac.uk/~vgg/data/flowers/17/"
	flowers17_name = "17flowers.tgz"
	train_dir      = "dataset"

	if not os.path.exists(train_dir):
		os.makedirs(train_dir)

	download_dataset(flowers17_name, flowers17_url, train_dir)
	if os.path.exists(train_dir + "\\jpg"):
		os.rename(train_dir + "\\jpg", train_dir + "\\train")


	# get the class label limit
	class_limit = 17

	# take all the images from the dataset
	image_paths = glob.glob(train_dir + "\\train\\*.jpg")

	# variables to keep track
	label = 0
	i = 0
	j = 80

	# flower17 class names
	class_names = ["daffodil", "snowdrop", "lilyvalley", "bluebell", "crocus",
			   	   "iris", "tigerlily", "tulip", "fritillary", "sunflower", 
			       "daisy", "coltsfoot", "dandelion", "cowslip", "buttercup",
			       "windflower", "pansy"]

	# loop over the class labels
	for x in range(1, class_limit+1):
		# create a folder for that class
		os.makedirs(train_dir + "\\train\\" + class_names[label])
		
		# get the current path
		cur_path = train_dir + "\\train\\" + class_names[label] + "\\"
		
		# loop over the images in the dataset
		for index, image_path in enumerate(image_paths[i:j], start=1):
			original_path   = image_path
			image_path      = image_path.split("\\")
			image_file_name = str(index) + ".jpg"
			os.rename(original_path, cur_path + image_file_name)
		
		i += 80
		j += 80
		label += 1
