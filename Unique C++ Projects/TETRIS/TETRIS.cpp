#include <iostream>
#include <Windows.h>
#include <conio.h>
#include <chrono>
#include <thread>

#define SOLID_PIXEL 0x2588
#define WHITE 0x000F

enum
{
	I_PIECE,
	L_PIECE,
	J_PIECE,
	S_PIECE,
	Z_PIECE,
	O_PIECE,
	T_PIECE,
};

enum
{
	LEFT = -1,
	RIGHT = 1,
};

class World;

class Console
{
private:
	SHORT nScreenHeight;
	SHORT nScreenWidth;
	SHORT nPixelHeight;
	SHORT nPixelWidth;
	HANDLE stdInputHandle;
	HANDLE stdOutputHandle;
	SMALL_RECT Window;
	static Console _console;
	Console()
	{
		stdInputHandle = GetStdHandle(STD_INPUT_HANDLE);
		stdOutputHandle = GetStdHandle(STD_OUTPUT_HANDLE);
		nScreenHeight = 0;
		nScreenWidth = 0;
		nPixelHeight = 0;
		nPixelWidth = 0;
		Window = {0, 0, 1, 1};
	}
	~Console()
	{
		CloseHandle(stdInputHandle);
	}

public:
	static Console &getConsole()
	{
		return _console;
	}

	void createConsole(int ScreenWidth, int ScreenHeight, int PixelWidth, int PixelHeight)
	{
		nScreenHeight = ScreenHeight;
		nScreenWidth = ScreenWidth;
		nPixelHeight = PixelHeight;
		nPixelWidth = PixelWidth;

		SetConsoleWindowInfo(stdOutputHandle, TRUE, &Window);

		if (!SetConsoleScreenBufferSize(stdOutputHandle, {nScreenWidth, nScreenHeight}))
		{
			std::cout << "Problem In Setting Buffer Size";
			exit(-1);
		}

		CONSOLE_FONT_INFOEX consoleFont;
		consoleFont.cbSize = sizeof(consoleFont);
		consoleFont.dwFontSize.X = nPixelWidth;
		consoleFont.dwFontSize.Y = nPixelHeight;
		wcscpy_s(consoleFont.FaceName, L"Consolas");
		consoleFont.FontFamily = FF_DONTCARE;
		consoleFont.FontWeight = FW_NORMAL;
		consoleFont.nFont = 0;

		if (!SetCurrentConsoleFontEx(stdOutputHandle, FALSE, &consoleFont))
		{
			std::cout << "Problem In Setting Font Information";
			SetConsoleWindowInfo(stdOutputHandle, TRUE, &Window);
			exit(-1);
		}

		CONSOLE_SCREEN_BUFFER_INFO screenBufferInfo;

		if (!GetConsoleScreenBufferInfo(stdOutputHandle, &screenBufferInfo))
		{
			std::cout << "Problem In Fetching Buffer Information";
			exit(-1);
		}

		if (nScreenWidth > screenBufferInfo.dwMaximumWindowSize.X)
		{
			std::cout << "Screen || Font Width Is Too Big";
			exit(-1);
		}
		if (nScreenHeight > screenBufferInfo.dwMaximumWindowSize.Y)
		{
			std::cout << "Screen || Font Height Is Too Big";
			exit(-1);
		}

		Window = {0, 0, nScreenWidth - 1, nScreenHeight - 1};

		if (!SetConsoleWindowInfo(stdOutputHandle, TRUE, &Window))
		{
			std::cout << "Problem In Setting Window Size";
			exit(-1);
		}
	}

	void displayConsole();

	void setTitle(const wchar_t *title) const
	{
		SetConsoleTitle(title);
	}

	void enableMouseInput() const
	{
		if (!SetConsoleMode(stdInputHandle, ENABLE_EXTENDED_FLAGS | ENABLE_WINDOW_INPUT | ENABLE_MOUSE_INPUT))
		{
			clear();
			std::cout << "Problem In Enabling Mouse Input";
			exit(-1);
		}
	}

	void clear() const
	{
		system("cls");
	}
};

Console Console::_console;

class World
{
private:
	SHORT nScreenHeight;
	SHORT nScreenWidth;
	SHORT nPixelHeight;
	SHORT nPixelWidth;
	CHAR_INFO ScreenBuffer[40][40];
	int nLines = 0;
	int nLevel = 1;
	int nScore = 0;
	int nDelay = 100;
	static World _World;
	World() : ScreenBuffer{0}
	{
		nScreenHeight = nScreenWidth = 40;
		nPixelHeight = nPixelWidth = 15;

		for (int i = 7, j = 0; j < nScreenWidth; j++)
		{
			ScreenBuffer[i][j].Char.UnicodeChar = SOLID_PIXEL;
			ScreenBuffer[i][j].Attributes = WHITE;
		}

		for (int i = 3, j = 0; j < nScreenWidth; j++)
		{
			ScreenBuffer[i][j].Char.UnicodeChar = SOLID_PIXEL;
			ScreenBuffer[i][j].Attributes = WHITE;
		}

		for (int i = 4; i < 7; i++)
		{
			ScreenBuffer[i][14].Char.UnicodeChar = SOLID_PIXEL;
			ScreenBuffer[i][14].Attributes = WHITE;

			ScreenBuffer[i][25].Char.UnicodeChar = SOLID_PIXEL;
			ScreenBuffer[i][25].Attributes = WHITE;

			if (i == 5)
			{
				for (int i = 0; i < nScreenWidth; i++)
				{
					ScreenBuffer[5][i].Attributes = WHITE;
				}

				for (int i = 28; i < 35; i++)
				{
					ScreenBuffer[5][i].Char.UnicodeChar = L"LINES :"[i - 28];
					ScreenBuffer[5][i].Attributes = WHITE;
				}

				for (int i = 2; i < 9; i++)
				{
					ScreenBuffer[5][i].Char.UnicodeChar = L"LEVEL :"[i - 2];
					ScreenBuffer[5][i].Attributes = WHITE;
				}

				for (int i = 17; i < 22; i++)
				{
					ScreenBuffer[4][i].Char.UnicodeChar = L"SCORE"[i - 17];
					ScreenBuffer[4][i].Attributes = WHITE;
				}

				for (int i = 15; i < 25; i++)
				{
					ScreenBuffer[6][i].Attributes = WHITE;
				}
			}
		}

		for (int i = 12, j = 26; j < nScreenWidth; j++)
		{
			ScreenBuffer[i][j].Char.UnicodeChar = SOLID_PIXEL;
			ScreenBuffer[i][j].Attributes = WHITE;
		}

		for (int i = 10, j = 26; j < 36; j++)
		{
			ScreenBuffer[i][j].Char.UnicodeChar = L" NEXT -> "[j - 26];
			ScreenBuffer[i][j].Attributes = WHITE;
		}

		for (int i = 33, j = 0; j < nScreenWidth; j++)
		{
			ScreenBuffer[i][j].Char.UnicodeChar = SOLID_PIXEL;
			ScreenBuffer[i][j].Attributes = WHITE;
		}

		for (int i = 8; i < nScreenHeight - 7; i++)
		{
			for (int j = 14; j < nScreenWidth - 14; j++)
			{
				if (j == 14 || j == nScreenWidth - 15)
				{
					ScreenBuffer[i][j].Char.UnicodeChar = SOLID_PIXEL;
					ScreenBuffer[i][j].Attributes = WHITE;
				}
				else
				{
					ScreenBuffer[i][j].Char.UnicodeChar = L' ';
				}
			}
		}
	}

public:
	static World &getWorld()
	{
		return _World;
	}

	CHAR_INFO *getFrame()
	{
		return *ScreenBuffer;
	}

	SHORT getWorldHeight() const
	{
		return nScreenHeight;
	}
	SHORT getWorldWidth() const
	{
		return nScreenWidth;
	}
	SHORT getWorldPixelHeight() const
	{
		return nPixelHeight;
	}
	SHORT getWorldPixelWidth() const
	{
		return nPixelWidth;
	}

	int getLines() const
	{
		return nLines;
	}

	int getScore()
	{
		return nScore;
	}

	int getLevel()
	{
		return nLevel;
	}

	int getDelay()
	{
		return nDelay;
	}

	void CheckLine()
	{
		for (int i = 32; i >= 8; i--)
		{
			for (int j = 15; j < 25; j++)
			{
				if (ScreenBuffer[i][j].Char.UnicodeChar != SOLID_PIXEL)
					break;
				else if (j == 24)
				{
					nLines++;
					nScore += nLevel * 10;
					if (nLines % 5 == 0)
					{
						nLevel++;
						if (nDelay > 50)
						{
							nDelay -= 2;
						}
					}
					for (int k = i; k > 8; k--)
					{
						for (int l = 15; l < 25; l++)
						{
							ScreenBuffer[k][l].Char.UnicodeChar = ScreenBuffer[k - 1][l].Char.UnicodeChar;
							ScreenBuffer[k][l].Attributes = ScreenBuffer[k - 1][l].Attributes;
						}
					}

					for (int k = 15; k < 25; k++)
					{
						ScreenBuffer[8][k].Char.UnicodeChar = L' ';
					}
					i++;
				}
			}
		}
	}

	void gameOver()
	{
		for (int i = 32; i >= 8; i--)
		{
			for (int j = 15; j < nScreenWidth - 15; j++)
			{
				ScreenBuffer[i][j].Char.UnicodeChar = SOLID_PIXEL;
				ScreenBuffer[i][j].Attributes = (std::rand() % 8) + 1;
				Console::getConsole().displayConsole();
				std::this_thread::sleep_for(std::chrono::milliseconds(5));
			}
		}

		for (int i = 15; i < nScreenWidth - 15; i++)
		{
			ScreenBuffer[20][i].Char.UnicodeChar = L"GAME  OVER"[i - 15];
			ScreenBuffer[20][i].Attributes = WHITE;
			Console::getConsole().displayConsole();
			std::this_thread::sleep_for(std::chrono::milliseconds(30));
		}
	}
};

World World::_World;

void Console::displayConsole()
{
	WriteConsoleOutput(stdOutputHandle, World::getWorld().getFrame(), {nScreenWidth, nScreenHeight}, {0, 0}, &Window);
	WCHAR Stats[11];
	DWORD nLength;

	swprintf_s(Stats, 11, L"%02d", World::getWorld().getLevel());
	nLength = 2;
	WriteConsoleOutputCharacter(stdOutputHandle, Stats, nLength, {10, 5}, &nLength);

	swprintf_s(Stats, 11, L"%010d", World::getWorld().getScore());
	nLength = 10;
	WriteConsoleOutputCharacter(stdOutputHandle, Stats, nLength, {15, 6}, &nLength);

	swprintf_s(Stats, 11, L"%02d", World::getWorld().getLines());
	nLength = 2;
	WriteConsoleOutputCharacter(stdOutputHandle, Stats, nLength, {36, 5}, &nLength);
}

class Tetromino
{
protected:
	const SHORT totalRotation;
	const SHORT color;
	SHORT currentRotation;
	SHORT currentRow;
	SHORT currentColumn;
	SHORT rightCount;
	SHORT leftCount;
	SHORT rotationCount;
	int Score;
	int lines;
	SHORT xy[4][2] = {{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}};

public:
	Tetromino(SHORT col, SHORT CR) : totalRotation(4), color(col)
	{
		Score = 0;
		lines = 0;
		currentRotation = 0;
		currentRow = CR;
		currentColumn = 20;
		rightCount = 0;
		leftCount = 0;
		rotationCount = 0;
	}

	void moveDown(Tetromino *piece)
	{
		if (currentRow < 7)
		{
			currentRow = 7;
		}
		int counter = 0;
		CHAR_INFO(*ScreenBuffer)
		[40] = (CHAR_INFO(*)[40])World::getWorld().getFrame();
		WCHAR(*Piece)
		[4][4] = (WCHAR(*)[4][4])piece->getPiece();
		for (int i = currentRow, m = 0; i < currentRow + 4; i++, m++)
		{
			for (int j = currentColumn, n = 0; j < currentColumn + 4; j++, n++)
			{
				if (i == 7)
					break;
				if (Piece[currentRotation][m][n] == L'X')
				{
					ScreenBuffer[i][j].Char.UnicodeChar = SOLID_PIXEL;
					ScreenBuffer[i][j].Attributes = color;
					xy[counter][0] = i;
					xy[counter][1] = j;
					counter++;
				}
			}
		}
		currentRow++;
	}
	void moveRight()
	{
		rightCount++;
		currentColumn += 1;
		if (rightCount <= 10)
		{
			currentRow -= 1;
		}
		else
		{
			rightCount = 0;
		}
	}

	void moveLeft()
	{
		leftCount++;
		currentColumn -= 1;
		if (leftCount <= 10)
		{
			currentRow -= 1;
		}
		else
		{
			leftCount = 0;
		}
	}

	void rotatePiece()
	{
		rotationCount++;
		currentRotation = (currentRotation + 1) % totalRotation;
		if (rotationCount <= 2)
		{
			currentRow--;
		}
		else
		{
			rotationCount = 0;
		}
	}

	void clearLastAppearance()
	{
		CHAR_INFO(*ScreenBuffer)
		[40] = (CHAR_INFO(*)[40])World::getWorld().getFrame();
		for (int i = 0; i < 4; i++)
		{
			if (xy[i][0] != -1)
			{
				ScreenBuffer[xy[i][0]][xy[i][1]].Char.UnicodeChar = L' ';
			}
		}
	}

	void setPieceAgain()
	{
		CHAR_INFO(*ScreenBuffer)
		[40] = (CHAR_INFO(*)[40])World::getWorld().getFrame();
		for (int i = 0; i < 4; i++)
		{
			if (xy[i][0] != -1)
			{
				ScreenBuffer[xy[i][0]][xy[i][1]].Char.UnicodeChar = SOLID_PIXEL;
				ScreenBuffer[xy[i][0]][xy[i][1]].Attributes = color;
			}
		}
	}

	bool pathIsClear(Tetromino *piece)
	{
		CHAR_INFO(*ScreenBuffer)
		[40] = (CHAR_INFO(*)[40])World::getWorld().getFrame();
		WCHAR(*Piece)
		[4][4] = (WCHAR(*)[4][4])piece->getPiece();
		piece->clearLastAppearance();
		for (int i = currentRow, m = 0; i < currentRow + 4; i++, m++)
		{
			for (int j = currentColumn, n = 0; j < currentColumn + 4; j++, n++)
			{
				if (i == 7)
					break;
				if (Piece[currentRotation][m][n] == L'X' && ScreenBuffer[i][j].Char.UnicodeChar == SOLID_PIXEL)
				{
					if (i == 8)
					{
						World::getWorld().gameOver();
						system("pause");
						Console::getConsole().clear();
						exit(0);
					}
					piece->setPieceAgain();
					return FALSE;
				}
			}
		}
		return TRUE;
	}

	bool rotationIsClear(Tetromino *piece)
	{
		SHORT rotation = (currentRotation + 1) % totalRotation;
		CHAR_INFO(*ScreenBuffer)
		[40] = (CHAR_INFO(*)[40])World::getWorld().getFrame();
		WCHAR(*Piece)
		[4][4] = (WCHAR(*)[4][4])piece->getPiece();
		piece->clearLastAppearance();
		int temp = (rotationCount == 2) ? 0 : 1;
		for (int i = currentRow - temp, m = 0; i < currentRow - temp + 4; i++, m++)
		{
			for (int j = currentColumn, n = 0; j < currentColumn + 4; j++, n++)
			{
				if (i == 7)
					break;
				if (Piece[rotation][m][n] == L'X' && ScreenBuffer[i][j].Char.UnicodeChar == SOLID_PIXEL)
				{
					return FALSE;
				}
			}
		}
		return TRUE;
	}

	bool leftRightIsClear(Tetromino *piece, SHORT OFFSET)
	{
		CHAR_INFO(*ScreenBuffer)
		[40] = (CHAR_INFO(*)[40])World::getWorld().getFrame();
		WCHAR(*Piece)
		[4][4] = (WCHAR(*)[4][4])piece->getPiece();
		piece->clearLastAppearance();
		int temp;
		if (OFFSET == LEFT)
		{
			temp = (leftCount == 8) ? 0 : 1;
		}
		else
		{
			temp = (rightCount == 8) ? 0 : 1;
		}
		for (int i = currentRow - temp, m = 0; i < currentRow - temp + 4; i++, m++)
		{
			for (int j = currentColumn + OFFSET, n = 0; j < currentColumn + OFFSET + 4; j++, n++)
			{
				if (i == 7)
					break;
				if (Piece[currentRotation][m][n] == L'X' && ScreenBuffer[i][j].Char.UnicodeChar == SOLID_PIXEL)
				{
					return FALSE;
				}
			}
		}

		return TRUE;
	}

	void setNextPiece(int nextPiece, int nextColor);

	void removeNextPiece();

	virtual WCHAR *getPiece() = 0;

	virtual ~Tetromino() {}
};

class I_Piece : public Tetromino
{
private:
	WCHAR Piece[4][4][4] =
		{
			{{L'.', L'.', L'.', L'.'},
			 {L'X', L'X', L'X', L'X'},
			 {L'.', L'.', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}},
			{{L'.', L'.', L'X', L'.'},
			 {L'.', L'.', L'X', L'.'},
			 {L'.', L'.', L'X', L'.'},
			 {L'.', L'.', L'X', L'.'}},
			{
				{L'.', L'.', L'.', L'.'},
				{L'.', L'.', L'.', L'.'},
				{L'X', L'X', L'X', L'X'},
				{L'.', L'.', L'.', L'.'},
			},
			{
				{L'.', L'X', L'.', L'.'},
				{L'.', L'X', L'.', L'.'},
				{L'.', L'X', L'.', L'.'},
				{L'.', L'X', L'.', L'.'},
			}};

public:
	I_Piece(int Color) : Tetromino(Color, 7) {}

	WCHAR *getPiece() override
	{
		return **Piece;
	}
};

class J_Piece : public Tetromino
{
private:
	WCHAR Piece[4][4][4] =
		{
			{{L'X', L'.', L'.', L'.'},
			 {L'X', L'X', L'X', L'.'},
			 {L'.', L'.', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}},
			{{L'.', L'X', L'X', L'.'},
			 {L'.', L'X', L'.', L'.'},
			 {L'.', L'X', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}},
			{{L'.', L'.', L'.', L'.'},
			 {L'X', L'X', L'X', L'.'},
			 {L'.', L'.', L'X', L'.'},
			 {L'.', L'.', L'.', L'.'}},
			{{L'.', L'X', L'.', L'.'},
			 {L'.', L'X', L'.', L'.'},
			 {L'X', L'X', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}}};

public:
	J_Piece(int Color) : Tetromino(Color, 7) {}

	WCHAR *getPiece() override
	{
		return **Piece;
	}
};

class L_Piece : public Tetromino
{
private:
	WCHAR Piece[4][4][4] =
		{
			{{L'.', L'.', L'X', L'.'},
			 {L'X', L'X', L'X', L'.'},
			 {L'.', L'.', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}},
			{{L'.', L'X', L'.', L'.'},
			 {L'.', L'X', L'.', L'.'},
			 {L'.', L'X', L'X', L'.'},
			 {L'.', L'.', L'.', L'.'}},
			{{L'.', L'.', L'.', L'.'},
			 {L'X', L'X', L'X', L'.'},
			 {L'X', L'.', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}},
			{{L'X', L'X', L'.', L'.'},
			 {L'.', L'X', L'.', L'.'},
			 {L'.', L'X', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}}};

public:
	L_Piece(int Color) : Tetromino(Color, 7) {}

	WCHAR *getPiece() override
	{
		return **Piece;
	}
};

class O_Piece : public Tetromino
{
private:
	WCHAR Piece[4][4][4] =
		{
			{{L'X', L'X', L'.', L'.'},
			 {L'X', L'X', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}},
			{{L'X', L'X', L'.', L'.'},
			 {L'X', L'X', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}},
			{{L'X', L'X', L'.', L'.'},
			 {L'X', L'X', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}},
			{{L'X', L'X', L'.', L'.'},
			 {L'X', L'X', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}}};

public:
	O_Piece(int Color) : Tetromino(Color, 7) {}

	WCHAR *getPiece() override
	{
		return **Piece;
	}
};

class S_Piece : public Tetromino
{
private:
	WCHAR Piece[4][4][4] =
		{
			{{L'.', L'X', L'X', L'.'},
			 {L'X', L'X', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}},
			{{L'.', L'X', L'.', L'.'},
			 {L'.', L'X', L'X', L'.'},
			 {L'.', L'.', L'X', L'.'},
			 {L'.', L'.', L'.', L'.'}},
			{{L'.', L'.', L'.', L'.'},
			 {L'.', L'X', L'X', L'.'},
			 {L'X', L'X', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}},
			{{L'X', L'.', L'.', L'.'},
			 {L'X', L'X', L'.', L'.'},
			 {L'.', L'X', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}}};

public:
	S_Piece(int Color) : Tetromino(Color, 9) {}

	WCHAR *getPiece() override
	{
		return **Piece;
	}
};

class Z_Piece : public Tetromino
{
private:
	WCHAR Piece[4][4][4] =
		{
			{{L'X', L'X', L'.', L'.'},
			 {L'.', L'X', L'X', L'.'},
			 {L'.', L'.', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}},
			{{L'.', L'.', L'X', L'.'},
			 {L'.', L'X', L'X', L'.'},
			 {L'.', L'X', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}},
			{{L'.', L'.', L'.', L'.'},
			 {L'X', L'X', L'.', L'.'},
			 {L'.', L'X', L'X', L'.'},
			 {L'.', L'.', L'.', L'.'}},
			{{L'.', L'X', L'.', L'.'},
			 {L'X', L'X', L'.', L'.'},
			 {L'X', L'.', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}}};

public:
	Z_Piece(int Color) : Tetromino(Color, 9) {}

	WCHAR *getPiece() override
	{
		return **Piece;
	}
};

class T_Piece : public Tetromino
{
private:
	WCHAR Piece[4][4][4] =
		{
			{{L'.', L'X', L'.', L'.'},
			 {L'X', L'X', L'X', L'.'},
			 {L'.', L'.', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}},
			{{L'.', L'X', L'.', L'.'},
			 {L'.', L'X', L'X', L'.'},
			 {L'.', L'X', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}},
			{{L'.', L'.', L'.', L'.'},
			 {L'X', L'X', L'X', L'.'},
			 {L'.', L'X', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}},
			{{L'.', L'X', L'.', L'.'},
			 {L'X', L'X', L'.', L'.'},
			 {L'.', L'X', L'.', L'.'},
			 {L'.', L'.', L'.', L'.'}}};

public:
	T_Piece(int Color) : Tetromino(Color, 7) {}

	WCHAR *getPiece() override
	{
		return **Piece;
	}
};

void Tetromino::setNextPiece(int nextPiece, int nextColor)
{
	CHAR_INFO(*ScreenBuffer)
	[40] = (CHAR_INFO(*)[40])World::getWorld().getFrame();

	WCHAR(*piece)
	[4] = NULL;

	Tetromino *Piece = NULL;
	switch (nextPiece)
	{
	case I_PIECE:
		Piece = new I_Piece(nextColor);
		piece = (WCHAR(*)[4])Piece->getPiece();
		break;
	case J_PIECE:
		Piece = new J_Piece(nextColor);
		piece = (WCHAR(*)[4])Piece->getPiece();
		break;
	case L_PIECE:
		Piece = new L_Piece(nextColor);
		piece = (WCHAR(*)[4])Piece->getPiece();
		break;
	case O_PIECE:
		Piece = new O_Piece(nextColor);
		piece = (WCHAR(*)[4])Piece->getPiece();
		break;
	case T_PIECE:
		Piece = new T_Piece(nextColor);
		piece = (WCHAR(*)[4])Piece->getPiece();
		break;
	case S_PIECE:
		Piece = new S_Piece(nextColor);
		piece = (WCHAR(*)[4])Piece->getPiece();
		break;
	case Z_PIECE:
		Piece = new Z_Piece(nextColor);
		piece = (WCHAR(*)[4])Piece->getPiece();
		break;
	}

	for (int i = 9; i < 11; i++)
	{
		for (int j = 35; j < 39; j++)
		{
			if (piece[i - 9][j - 35] == L'X')
			{
				ScreenBuffer[i][j].Char.UnicodeChar = SOLID_PIXEL;
				ScreenBuffer[i][j].Attributes = nextColor;
			}
		}
	}

	delete Piece;
}

void Tetromino::removeNextPiece()
{
	CHAR_INFO(*ScreenBuffer)
	[40] = (CHAR_INFO(*)[40])World::getWorld().getFrame();
	for (int i = 9; i < 11; i++)
	{
		for (int j = 35; j < 39; j++)
		{
			ScreenBuffer[i][j].Char.UnicodeChar = L' ';
		}
	}
}

class Tetris
{
	Tetris(){};

public:
	static void START()
	{
		int ScreenWidth = World::getWorld().getWorldWidth();
		int ScreenHeight = World::getWorld().getWorldHeight();
		int PixelWidth = World::getWorld().getWorldPixelWidth();
		int PixelHeight = World::getWorld().getWorldPixelWidth();
		Console::getConsole().createConsole(ScreenWidth, ScreenHeight, PixelWidth, PixelHeight);
		Console::getConsole().enableMouseInput();
		wchar_t title[35];
		wcscpy_s(title, LR"(TETRIS)");
		Console::getConsole().setTitle(title);

		bool temp = false;
		int nPiece;
		int nColor;
		int nextPiece;
		int nextColor;
		while (TRUE)
		{
			srand(time(0));

			if (!temp)
			{
				nPiece = std::rand() % 7;
				nColor = (std::rand() % 8) + 1;
				temp = true;
			}
			else
			{
				nPiece = nextPiece;
				nColor = nextColor;
			}

			nextPiece = std::rand() % 7;
			nextColor = (std::rand() % 8) + 1;
			;

			switch (nPiece)
			{
			case I_PIECE:
			{
				Tetromino *Piece = new I_Piece(nColor);
				Piece->setNextPiece(nextPiece, nextColor);
				MOVE(Piece);
				Piece->removeNextPiece();
				delete Piece;
				break;
			}
			case L_PIECE:
			{
				Tetromino *Piece = new L_Piece(nColor);
				Piece->setNextPiece(nextPiece, nextColor);
				MOVE(Piece);
				Piece->removeNextPiece();
				delete Piece;
				break;
			}
			case J_PIECE:
			{
				Tetromino *Piece = new J_Piece(nColor);
				Piece->setNextPiece(nextPiece, nextColor);
				MOVE(Piece);
				Piece->removeNextPiece();
				delete Piece;
				break;
			}
			case S_PIECE:
			{
				Tetromino *Piece = new S_Piece(nColor);
				Piece->setNextPiece(nextPiece, nextColor);
				MOVE(Piece);
				Piece->removeNextPiece();
				delete Piece;
				break;
			}
			case Z_PIECE:
			{
				Tetromino *Piece = new Z_Piece(nColor);
				Piece->setNextPiece(nextPiece, nextColor);
				MOVE(Piece);
				Piece->removeNextPiece();
				delete Piece;
				break;
			}
			case O_PIECE:
			{
				Tetromino *Piece = new O_Piece(nColor);
				Piece->setNextPiece(nextPiece, nextColor);
				MOVE(Piece);
				Piece->removeNextPiece();
				delete Piece;
				break;
			}
			case T_PIECE:
			{
				Tetromino *Piece = new T_Piece(nColor);
				Piece->setNextPiece(nextPiece, nextColor);
				MOVE(Piece);
				Piece->removeNextPiece();
				delete Piece;
				break;
			}
			}
		}
	}

	static void MOVE(Tetromino *Piece)
	{
		BOOL pieceIsSet = FALSE;

		int delay = World::getWorld().getDelay();

		do
		{

			if (GetAsyncKeyState(VK_UP) < 0)
			{
				if (Piece->rotationIsClear(Piece))
				{
					Piece->rotatePiece();
					Piece->moveDown(Piece);
					std::this_thread::sleep_for(std::chrono::milliseconds(120));
				}
				else
				{
					if (Piece->pathIsClear(Piece))
					{
						Piece->moveDown(Piece);
						std::this_thread::sleep_for(std::chrono::milliseconds(delay));
					}
					else
					{
						pieceIsSet = TRUE;
					}
				}
			}
			else if (GetAsyncKeyState(VK_DOWN) < 0)
			{
				if (Piece->pathIsClear(Piece))
				{
					Piece->moveDown(Piece);
					std::this_thread::sleep_for(std::chrono::milliseconds(8));
				}
				else
				{
					pieceIsSet = TRUE;
				}
			}
			else if (GetAsyncKeyState(VK_LEFT) < 0)
			{
				if (Piece->leftRightIsClear(Piece, LEFT))
				{
					Piece->moveLeft();
					if (Piece->pathIsClear(Piece))
					{
						Piece->moveDown(Piece);
					}
					else
					{
						pieceIsSet = TRUE;
					}
					std::this_thread::sleep_for(std::chrono::milliseconds(50));
				}
				else
				{
					if (Piece->pathIsClear(Piece))
					{
						Piece->moveDown(Piece);
						std::this_thread::sleep_for(std::chrono::milliseconds(delay));
					}
					else
					{
						pieceIsSet = TRUE;
					}
				}
			}
			else if (GetAsyncKeyState(VK_RIGHT) < 0)
			{
				if (Piece->leftRightIsClear(Piece, RIGHT))
				{
					Piece->moveRight();
					if (Piece->pathIsClear(Piece))
					{
						Piece->moveDown(Piece);
					}
					else
					{
						pieceIsSet = TRUE;
					}
					std::this_thread::sleep_for(std::chrono::milliseconds(50));
				}
				else
				{
					if (Piece->pathIsClear(Piece))
					{
						Piece->moveDown(Piece);
						std::this_thread::sleep_for(std::chrono::milliseconds(delay));
					}
					else
					{
						pieceIsSet = TRUE;
					}
				}
			}
			else
			{

				if (Piece->pathIsClear(Piece))
				{
					Piece->moveDown(Piece);
					std::this_thread::sleep_for(std::chrono::milliseconds(delay));
				}
				else
				{
					pieceIsSet = TRUE;
				}
			}
			Console::getConsole().displayConsole();
		} while (pieceIsSet != TRUE);
		World::getWorld().CheckLine();
	}
};

int main()
{
	Tetris::START();
	return 0;
}