from exam_service.exam.models.exam import Exam
from rest_framework import generics


class ExamList(generics.ListAPIView):
    queryset = Exam.objects.all()
    serializer_class = ...


class ExamView(generics.RetrieveAPIView):
    queryset = Exam.objects.all()
    serializer_class = ...