FROM python:latest

ENV PYTHONUNBUFFERED 1

RUN ln -s /bin/pip3.10 /bin/pip
RUN ln -s /usr/bin/python3.10 /usr/bin/python3.10
RUN pip install --upgrade pip
RUN pip3 install poetry

ENV SRC_PROJECT_PATH /code
RUN mkdir -p $SRC_PROJECT_PATH

WORKDIR $SRC_PROJECT_PATH

ADD ./src/pyproject.toml $SRC_PROJECT_PATH/
ADD ./src/poetry.lock $SRC_PROJECT_PATH/

ENV LANG=en_US.utf8

RUN poetry install --ansi

ADD ./src $SRC_PROJECT_PATH/
ADD ./conf /conf/


RUN poetry install
