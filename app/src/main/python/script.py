import random
def analyse(text):
    words = ['sad', 'low', 'bad mood', 'unhappy']


    for word in words:
        if word in text:
            sentiment = 'sad'
            break
    set1=['angry','furious','irritated','annoyed','annoying','Furious','enraged','mad','upset','fuming']
    for set in set1:
        if set in text:
            sentiment='anger'
            break

    set2=['anxious','scared','fear','worried','tensed']
    for se in set2:
        if se in text:
            sentiment='anxiety'
            break


    return sentiment

def suggest_methods(sentiment):
    suggestions = {
        'happy': ["Continue doing things that bring you joy and spend time with loved ones."],


        'sad':["Try engaging in activities that uplift your mood, such as listening to music or talking to a supportive friend.",
               "Go for a walk in nature and enjoy some fresh air.",
               "Watch a funny movie or TV show to lift your spirits.",
               "Write down your feelings in a journal to express and process your emotions.",
               "Engage in a creative activity, such as painting, writing, or playing a musical instrument."],


        'anger': [ "Practice deep breathing and find healthy ways to release anger, like exercising or journaling.",
                   "Take a break and remove yourself from the situation causing anger.",
                   "Talk to a trusted friend or family member about your feelings.",
                   "Practice mindfulness or meditation to calm your mind.",
                   "Redirect your energy into a productive activity, such as cleaning or organizing." ],
        'anxiety': [
            "Practice relaxation techniques such as deep breathing exercises or meditation.",
            "Create a calming routine and focus on self-care activities.",
            "Engage in regular physical exercise to reduce anxiety.",
            "Limit exposure to stressful triggers and practice setting boundaries.",
            "Consider seeking professional help or talking to a therapist."
        ]

    }

    suggestions_for_sentiment = suggestions.get(sentiment)
    random_activity = random.choice(suggestions_for_sentiment)

    return random_activity

def main(txt):

    sent=analyse(txt)
    sugg= suggest_methods(sent)
    return sugg
