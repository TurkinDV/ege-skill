from django.contrib import admin

from exam_service.exam.models.exam import Exam
from exam_service.exam.models.question import Question


class QuestionInlines(admin.StackedInline):
    model = Question
    extra = 0


@admin.register(Exam)
class ExamAdmin(admin.ModelAdmin):
    inlines = [QuestionInlines]


admin.site.register(Question)

