#This program is to convert youtube video format to mp3 format
import youtube_dl
import sys


#to choose the best audio format available , the 'preffereddcode' will be mp3 and rest will be as it is 
ydl_opts = {
    'format': 'bestaudio/best' ,
    'postprocessors': [{
        'key': 'FFmpegExtractAudio',
        'preferredcodec': 'mp3',
        'preferredquality': '192',
    }],
}

if __name__ == '__main__':
    with youtube_dl.YoutubeDL(ydl_opts) as ydl:
        filenames = sys.argv[1:]
        ydl.download(filenames)

#For output type python youtube mp3 download followed by <your youtube's url>