import tkinter

import random


class ColorGame:
    colors = ["Red", "Yellow", "Orange", "Green", "Blue", "Purple", "Black", "White", "Pink"]

    time_left = 30

    score = 0

    def __init__(self, window):

        window.title("Color Game")

        window.geometry("400x250")

        self.instruction_label = tkinter.Label(window, text="Type the color of the word, not the text!",

                                               font=("Century", 14))

        self.instruction_label.pack(pady=10)

        self.start_label = tkinter.Label(window, text="Press Enter to Start.", font=("Copperplate Gothic Light", 12))

        self.start_label.pack()

        self.score_label = tkinter.Label(window, text="Score: 0", font=("Comic Sans MS", 14))

        self.time_label = tkinter.Label(window, text="Time Left: " + str(self.time_left),

                                        font=("Arial", 14))

        self.color_text_label = tkinter.Label(window, fg=self.colors[0], text="Color", font=("Times", 40))

        self.entry = tkinter.Entry(window, font=("Arial", 14))

        self.play_again_button = tkinter.Button(window, text="Play Again", font=("Arial", 14), padx=3,

                                                pady=3, background="Green", fg="White", command=self.restart)

        window.bind("<Return>", self.play_game)

    def play_game(self, event):

        self.start_label.pack_forget()

        self.score_label.pack()

        self.time_label.pack()

        self.color_text_label.pack()

        self.entry.pack(fill="x", padx=100)

        if self.time_left > 0:

            self.entry.focus_set()

            if self.time_left == 30:
                self.countdown()

            self.change_color()

        else:

            self.color_text_label.pack_forget()

            self.entry.pack_forget()

            self.play_again_button.pack(pady=10)

    def change_color(self):

        self.check_answer()

        random.shuffle(self.colors)

        self.color_text_label.config(fg=self.colors[0], text=self.colors[1])

        self.color_text_label.pack(pady=13)

    def check_answer(self):

        if self.entry.get().lower() == self.colors[0].lower():
            self.score += 1

            self.score_label.config(text="Score: " + str(self.score))

        self.entry.delete(0, tkinter.END)

    def countdown(self):

        if self.time_left > 0:
            self.time_left -= 1

            self.time_label.config(text="Time Left: " + str(self.time_left))

            self.time_label.after(1000, self.countdown)

    def restart(self):

        self.score = 0

        self.time_left = 30

        self.score_label.config(text="Score: 0")

        self.time_label.config(text="Time Left: " + str(self.time_left))

        self.play_again_button.pack_forget()

        self.score_label.pack_forget()

        self.time_label.pack_forget()

        self.start_label.pack()

new_window = tkinter.Tk()

game = ColorGame(new_window)
new_window.mainloop()
