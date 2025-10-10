
#source directory

SOURCE := src
OUT := out

SRCS := $(wildcard $(SOURCE)/*.java)

CLS := $(SRCS:$(SOURCE)/%.java=$(OUT)/%.class)

JC := javac
JAV := java
JCFLAGS := -d $(OUT)/ -cp $(SOURCE)/


.PHONY: all clean

all: $(CLS)

$(CLS): $(OUT)/%.class: $(SOURCE)/%.java
	$(JC) $(JCFLAGS) $<
clean:
	rm $(OUT_DIR)/*.class

