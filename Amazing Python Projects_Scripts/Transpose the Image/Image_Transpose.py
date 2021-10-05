from PIL import Image
img = Image.open("one.jpg")  # Image which to be Trnaspose
Img_Trans = img.transpose(Image.FLIP_LEFT_RIGHT)
Img_Trans.save("one_one.jpg")
