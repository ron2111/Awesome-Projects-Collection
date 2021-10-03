from pytube import YouTube

url = input("Enter the youtube link URL: ")
yt = YouTube(url)

print(f"Title: {yt.title}")
videos = yt.streams

for i,video in enumerate(videos):
    print(f"{str(i)} {str(video)}")

num = int(input("Enter your choice: "))
video = videos[num]
print("Downloading the video. Please wait...")
video.download()