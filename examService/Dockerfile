FROM python:latest

MAINTAINER Dmitrii Turkin "dmitry_turkin@mail.ru"

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

CMD [ "uwsgi", "--module", "exam_service.wsgi:application", "--env", "DJANGO_SETTINGS_MODULE=exam_service.settings", "--master", "--http", ":8080", "--py-autoreload", "1"]

EXPOSE 8080