import pygame
import sys
import random


def draw_floor():
    screen.blit(floor_surface, (floor_x_pos, screen_height - (infoObject.current_h // 10)))
    screen.blit(floor_surface, (floor_x_pos + screen_width, screen_height - (infoObject.current_h // 10)))


def create_pipe():
    random_pipe_pos = random.choice(pipe_height)
    bottom_pipe = pipe_surface.get_rect(midtop=(screen_width * (6 / 5), random_pipe_pos))
    top_pipe = pipe_surface.get_rect(midbottom=(screen_width * (6 / 5), random_pipe_pos - (screen_height // 100) * 26))
    return bottom_pipe, top_pipe


def move_pipes(pipes):
    for pipe in pipes:
        pipe.centerx -= 3
    return pipes


def draw_pipes(pipes):
    for pipe in pipes:
        if pipe.bottom >= screen_height:
            screen.blit(pipe_surface, pipe)
        else:
            flip_pipe = pygame.transform.flip(pipe_surface, False, True)
            screen.blit(flip_pipe, pipe)


def check_collision(pipes):
    global can_score

    for pipe in pipes:
        if bird_rect.colliderect(pipe):
            if not muted:
                death_sound.play()
            can_score = True
            return False

    if bird_rect.top <= 0 or bird_rect.bottom >= screen_height - (infoObject.current_h // 10):
        if not muted:
          death_sound.play()
        return False

    return True


def rotate_bird(bird):
    new_bird = pygame.transform.rotozoom(bird, -bird_movement * 2.5, 1)
    return new_bird


def bird_animation():
    new_bird = bird_frames[bird_index]
    new_bird = pygame.transform.scale(new_bird, (screen_width // 10, screen_height // 20))
    new_bird_rect = new_bird.get_rect(center=(screen_width // 10, bird_rect.centery))
    return new_bird, new_bird_rect


def score_display(game_state):
    if game_state == 'playing':
        score_surface = game_font.render(str(int(score)), True, (255, 255, 255))
        score_rect = score_surface.get_rect(center=(screen_width // 2, screen_height // 20))
        screen.blit(score_surface, score_rect)

    if game_state == 'over':
        score_surface = game_font.render("Score = {}".format(int(score)), True, (255, 255, 255))
        score_rect = score_surface.get_rect(center=(screen_width // 2, screen_height // 20))
        screen.blit(score_surface, score_rect)

        high_score_surface = game_font.render("Highscore = {}".format(int(high_score)), True, (255, 255, 255))
        high_score_rect = high_score_surface.get_rect(center=(screen_width // 2, screen_height // 1.2))
        screen.blit(high_score_surface, high_score_rect)
        screen.blit(game_over_screen, game_over_rect)


def pipe_score_check():
    global score, can_score
    if pipe_list:
        for pipe in pipe_list:
            if (screen_width // 10) - 1 < pipe.centerx < (screen_width // 10) + 1 and can_score:
                score += 1
                if not muted:
                    score_sound.play()
                can_score = False
            if pipe.centerx < 0:
                can_score = True


def game_paused():
    paused_surface = game_font.render("Paused", True, (255, 255, 255))
    paused_surface = pygame.transform.scale2x(paused_surface)
    paused_rect = paused_surface.get_rect(center=(screen_width // 2, screen_height // 7))
    continue_surface = game_font.render("Esc or P to Continue", True, (255, 255, 255))
    continue_rect = continue_surface.get_rect(center=(screen_width // 2, screen_height // 2.7))
    quit_surface = game_font.render("Q to Quit", True, (255, 255, 255))
    quit_rect = quit_surface.get_rect(center=(screen_width // 2, screen_height // 4))
    mute_surface = game_font.render("M to Mute", True, (255, 255, 255))
    mute_rect = mute_surface.get_rect(center=(screen_width // 2, screen_height // 3.2))
    screen.blit(dim_screen, dim_rect)
    screen.blit(paused_surface, paused_rect)
    screen.blit(continue_surface, continue_rect)
    screen.blit(quit_surface, quit_rect)
    screen.blit(mute_surface, mute_rect)
    pygame.display.update()


pygame.init()
infoObject = pygame.display.Info()
screen_width = infoObject.current_w // 3
screen_height = infoObject.current_h - 60
screen = pygame.display.set_mode((screen_width, screen_height), pygame.RESIZABLE)
clock = pygame.time.Clock()

game_font = pygame.font.Font('04B_19.TTF', 40)
game_over_screen = pygame.image.load('assets/intro_message.png').convert_alpha()
game_over_screen = pygame.transform.scale(game_over_screen, (screen_width // 2, screen_height // 2))
game_over_rect = game_over_screen.get_rect(center=(screen_width // 2, screen_height // 2))

dim_screen = pygame.Surface((screen_width, screen_height)).convert_alpha()
dim_rect = dim_screen.get_rect(center=(screen_width // 2, screen_height // 2))
dim_screen.fill((0, 0, 0, 180))

flap_sound = pygame.mixer.Sound('sound/sfx-wing-redux.wav')
death_sound = pygame.mixer.Sound('sound/die-sound.wav')
score_sound = pygame.mixer.Sound('sound/sfx-point-redux.wav')
pygame.mixer.music.load("sound/background.wav")
pygame.mixer.music.set_volume(0.65)
pygame.mixer.music.play(-1, 0.0)

# Game Variables
gravity = 0.2
bird_movement = 0
game_active = True
score = 0
high_score = 0
can_score = True
paused = False
muted = False

bg_surface = pygame.image.load("assets/background-night.png").convert_alpha()
bg_surface = pygame.transform.scale(bg_surface, (screen_width, screen_height))

floor_surface = pygame.image.load("assets/base-cloud.png").convert_alpha()
floor_surface = pygame.transform.scale(floor_surface, (screen_width, screen_height // 5))
floor_x_pos = 0

bird_downflap = pygame.image.load('assets/redbird-downflap.png').convert_alpha()
bird_midflap = pygame.image.load('assets/redbird-midflap.png').convert_alpha()
bird_upflap = pygame.image.load('assets/redbird-upflap.png').convert_alpha()
bird_frames = [bird_downflap, bird_midflap, bird_upflap]
bird_index = 0
bird_surface = pygame.transform.scale(bird_frames[bird_index], (screen_width // 10, screen_height // 20))
bird_rect = bird_surface.get_rect(center=(screen_width // 10, screen_height // 2))

BIRDFLAP = pygame.USEREVENT + 1
pygame.time.set_timer(BIRDFLAP, 200)

pipe_surface = pygame.image.load("assets/cloud-flipped3.png").convert_alpha()
pipe_surface = pygame.transform.scale(pipe_surface, (screen_width // 3, screen_height))
pipe_list = []
SPAWNPIPE = pygame.USEREVENT
pygame.time.set_timer(SPAWNPIPE, 1400)
pipe_height_bottom_half = [screen_height // (i / 10) for i in range(13, 16)]
pipe_height_top_half = [screen_height * (i / 10) for i in range(3, 8)]
pipe_height = pipe_height_bottom_half + pipe_height_top_half

while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_SPACE and game_active and not paused:
                bird_movement = 0
                bird_movement -= 6
                if not muted:
                    flap_sound.play()
            if event.key == pygame.K_SPACE and not game_active and not paused:
                game_active = True
                pipe_list.clear()
                bird_rect.center = (screen_width // 10, screen_height // 2)
                bird_movement = -4
                score = 0
            if event.key == pygame.K_ESCAPE or event.key == pygame.K_p:
                paused = not paused
                if paused:
                    bird_movement = 0
                    game_paused()
            if event.key == pygame.K_q:
                pygame.quit()
                sys.exit()
            if event.key == pygame.K_m:
                muted = not muted
                if muted:
                    pygame.mixer.music.pause()
                else:
                    pygame.mixer.music.unpause()

        if event.type == SPAWNPIPE and not paused:
            if len(pipe_list) >= 3:
                if (pipe_list[-1].centerx - pipe_list[-3].centerx) >= screen_width // 3:
                    pipe_list.extend(create_pipe())
            else:
                pipe_list.extend(create_pipe())
            if len(pipe_list) >= 8:
                pipe_list.pop(0)
                pipe_list.pop(1)

        if event.type == BIRDFLAP and not paused:
            if bird_index < 2:
                bird_index += 1
            else:
                bird_index = 0
            bird_surface, bird_rect = bird_animation()

    screen.blit(bg_surface, (0, 0))

    if game_active and not paused:
        # Bird
        bird_movement += gravity
        rotated_bird = rotate_bird(bird_surface)
        bird_rect.centery += bird_movement
        screen.blit(rotated_bird, bird_rect)
        game_active = check_collision(pipe_list)

        # Pipes
        pipe_list = move_pipes(pipe_list)
        draw_pipes(pipe_list)

        # Score
        pipe_score_check()
        if score > high_score:
            high_score = score
        score_display('playing')
    else:
        score_display('over')

    if not paused:
        # Floor
        floor_x_pos -= 0.8
        draw_floor()
        if floor_x_pos < -screen_width:
            floor_x_pos = 0
        pygame.display.update()
    clock.tick(120)
